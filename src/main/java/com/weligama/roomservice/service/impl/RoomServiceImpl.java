package com.weligama.roomservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weligama.roomservice.entity.RoomEntity;
import com.weligama.roomservice.model.Room;
import com.weligama.roomservice.repository.RoomRepository;
import com.weligama.roomservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    RoomRepository roomRepository;

    @Override
    public RoomEntity addRoom(Room room){
        RoomEntity entity = mapper.convertValue(room, RoomEntity.class);

        return roomRepository.save(entity);
    }
}
