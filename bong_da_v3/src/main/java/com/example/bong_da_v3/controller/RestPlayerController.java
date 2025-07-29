package com.example.bong_da_v3.controller;

import com.example.bong_da_v3.entity.Location;
import com.example.bong_da_v3.entity.Player;
import com.example.bong_da_v3.service.ILocationService;
import com.example.bong_da_v3.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/players")
public class RestPlayerController {
    @Autowired
    private IPlayerService playerService;
    @Autowired
    private ILocationService locationService;
    @GetMapping("")
    public ResponseEntity<Page<Player>> showList(@RequestParam(required = false, defaultValue = "0") int page,
                                                 @RequestParam(required = false, defaultValue = "5") int size,
                                                 @RequestParam(required = false, defaultValue = "") String name,
                                                 @RequestParam(required = false, defaultValue = "") String nameLocation,
                                                 Model model){
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Player> playerPage = playerService.search(name,nameLocation,pageable);
        return new  ResponseEntity<>(playerPage, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.findAll();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody Player player){
        if (player.getStatus() == null || player.getStatus().isBlank()) {
            player.setStatus("Dự bị");
        }
        playerService.add(player);
        return new ResponseEntity<>(player,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.findById(id);
        if (player.isPresent()) {
            return new ResponseEntity<>(player.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không tìm thấy cầu thủ", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable Long id,
                                          @Validated @RequestBody Player updatedPlayer) {
        Optional<Player> optionalPlayer = playerService.findById(id);
        if (optionalPlayer.isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy cầu thủ để cập nhật", HttpStatus.NOT_FOUND);
        }

        Player existingPlayer = optionalPlayer.get();
        existingPlayer.setPlayerCode(updatedPlayer.getPlayerCode());
        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setBirthday(updatedPlayer.getBirthday());
        existingPlayer.setExperience(updatedPlayer.getExperience());
        existingPlayer.setImage(updatedPlayer.getImage());
        existingPlayer.setLocation(updatedPlayer.getLocation());
        existingPlayer.setStatus(updatedPlayer.getStatus());

        playerService.save(existingPlayer);
        return new ResponseEntity<>(existingPlayer, HttpStatus.OK);
    }
    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        return new ResponseEntity<>(locationService.findAll(), HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions (
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage ();
            errors.put(fieldName, errorMessage);
        }) ;
        return errors;
    }

}
