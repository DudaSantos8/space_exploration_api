
"project": {
"name":"Space Exploration API",
"description": "API to simulate space exploration, manage spacecrafts, and interact with planets. The spacecraft has limited resources (fuel, oxygen, and energy) that are consumed during travels or by random events.",
"version": "1.0.0"
},
"api_endpoints": [
{
"method": "POST",
"path": "/api/spacecraft",
"description": "Create a new spacecraft.",
"request_body": {
"name": "Explorer 1",
"fuel": 100,
"oxygen": 80,
"energy": 90
},
"responses": [
{
"status_code": 201,
"description": "Spacecraft successfully created."
},
{
"status_code": 400,
"description": "Bad request, some resource is negative or missing."
}
]
},
{
"method": "GET",
"path": "/api/spacecraft/{id}",
"description": "Get the status of a specific spacecraft by its id.",
"responses": [
{
"status_code": 200,
"description": "Spacecraft status returned successfully.",
"body": {
"id": 1,
"name": "Explorer 1",
"fuel": 100,
"oxygen": 80,
"energy": 90
}
},
{
"status_code": 404,
"description": "Spacecraft not found."
}
]
},
{
"method": "PUT",
"path": "/api/spacecraft/{id}/travel",
"description": "Perform travel to a specific planet, consuming fuel and oxygen.",
"query_parameters": {
"planetId": "ID of the planet to travel to."

"responses": [
{
"status_code": 200,
"description": "Travel completed successfully.",
"body": {
"message": "Travel to planet Mars completed!"
}
},
{
"status_code": 400,
"description": "Insufficient resources to make the travel."
},
{
"status_code": 404,
"description": "Spacecraft or planet not found."
}
{
"method": "POST",
"path": "/api/spacecraft/{id}/event",
"description": "Resolve a random event affecting the spacecraft’s resources.",
"responses": [
{
"status_code": 200,
"description": "Event resolved and resources updated.",
"body": {
"event": "Engine failure! Extra fuel consumed.",
"spacecraftStatus": {
"id": 1,
"name": "Explorer 1",
"fuel": 80,
"oxygen": 80,
"energy": 90
}
}
},
{
"status_code": 404,
"description": "Spacecraft not found."
}
]
},
{
"method": "DELETE",
"path": "/api/spacecraft/{id}",
"description": "Remove a spacecraft by its id.",
"responses": [
{
"status_code": 204,
"description": "Spacecraft successfully deleted."
},
{
"status_code": 404,
"description": "Spacecraft not found."
}
],
"event_responses": [
{
"event": "EVENT1",
"name": "Refueling Station",
"description": "The spaceship finds a refueling station and gets extra fuel.",
"typeFail": "fuel",
"effect": 30
},
{
"event": "EVENT2",
"name": "Engine Failure",
"description": "The engine failure consumes extra fuel.",
"typeFail": "fuel",
"effect": -10
},
{
"event": "EVENT3",
"name": "Oxygen Leak",
"description": "There’s a leak in the life support system, and oxygen is lost.",
"typeFail": "oxygen",
"effect": -15
},
{
"event": "EVENT4",
"name": "Oxygen Source Discovery",
"description": "The spaceship discovers a new oxygen source on a planet or station.",
"typeFail": "oxygen",
"effect": 20
},
{
"event": "EVENT5",
"name": "Solar Storm",
"description": "Reduces the spaceship’s energy due to solar interference.",
"typeFail": "energy",
"effect": -20
},
{
"event": "EVENT6",
"name": "Energy Repair",
"description": "The spaceship repairs its energy system and restores some energy.",
"typeFail": "energy",
"effect": 25
},
{
"event": "EVENT7",
"name": "Successful Exploration",
"description": "The spaceship successfully explores a new planet and recovers resources.",
"typeFail": "energy",
"effect": 10
},
{
"event": "EVENT8",
"name": "Communication Failure",
"description": "A failure in the communication system consumes more energy.",
"typeFail": "energy",
"effect": -10
},
{
"event": "EVENT9",
"name": "Cooling Failure",
"description": "The cooling system failed, causing increased oxygen consumption.",
"typeFail": "oxygen",
"effect": -20
},
{
"event": "EVENT10",
"name": "Internal Sabotage",
"description": "A crew member sabotaged the energy system, reducing energy.",
"typeFail": "energy",
"effect": -25
},
{
"event": "EVENT11",
"name": "Gravitational Avalanche",
"description": "A planet’s gravity alters the spaceship’s course, consuming more fuel and oxygen.",
"typeFail": "fuel",
"effect": -20
},
{
"event": "EVENT12",
"name": "Emergency Repairs",
"description": "The spaceship makes emergency repairs and restores some resources.",
"typeFail": "oxygen",
"effect": 5
}
],
"planet_responses": [
{
"name": "MERCURY",
"description": "The closest planet to the Sun. It has extreme temperatures and no atmosphere.",
"distanceSun": 57.91
},
{
"name": "VENUS",
"description": "A toxic and acidic atmosphere with surface temperatures higher than Mercury’s.",
"distanceSun": 108.2
},
{
"name": "EARTH",
"description": "Our home planet, with water and life. The only known planet to support life.",
"distanceSun": 149.6
},
{
"name": "MARS",
"description": "The Red Planet. Known for its thin atmosphere and potential for future colonization.",
"distanceSun": 227.9
},
{
"name": "JUPITER",
"description": "The largest planet in our solar system, a gas giant with massive storms.",
"distanceSun": 778.5
},
{
"name": "SATURN",
"description": "Famous for its beautiful rings. A gas giant with many moons.",
"distanceSun": 1433.5
},
{
"name": "URANUS",
"description": "An ice giant that rotates on its side, with a faint ring system.",
"distanceSun": 2872.5
},
{
"name": "NEPTUNE",
"description": "An ice giant with strong winds and deep blue color. Known for its cold atmosphere.",
"distanceSun": 4495.1
}
]
}