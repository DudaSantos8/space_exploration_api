package com.br.Space_Exploration.Domain.usercases;

import com.br.Space_Exploration.Domain.dtos.EventResponseDto;

public interface Event {
    EventResponseDto getEvent(int idSpacecraft);
}
