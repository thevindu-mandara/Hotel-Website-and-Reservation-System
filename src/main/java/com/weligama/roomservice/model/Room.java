package com.weligama.roomservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {
    private Long id;
    private String roomName;
    private String facilities;
    private String numberOfPax;
    private String floorNo;
    private Long rate;
}
