package com.weligama.roomservice.controller;
import com.weligama.roomservice.entity.RoomEntity;
import com.weligama.roomservice.model.Room;
import com.weligama.roomservice.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/room")
public class RoomController {


    private RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<RoomEntity> addRoom(@RequestBody Room room){
        try {
            RoomEntity savedRoom = roomService.addRoom(room);
            return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
