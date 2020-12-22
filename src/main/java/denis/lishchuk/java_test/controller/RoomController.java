package denis.lishchuk.java_test.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import denis.lishchuk.java_test.dto.request.RoomRequest;
import denis.lishchuk.java_test.dto.response.ErrorResponse;
import denis.lishchuk.java_test.dto.response.RoomResponse;
import denis.lishchuk.java_test.exception.InputDataException;
import denis.lishchuk.java_test.service.RoomService;
import denis.lishchuk.java_test.validators.ValidationSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/validateRoom")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping
    public Object save(@RequestBody @Validated(ValidationSequence.class) RoomRequest roomRequest, BindingResult br) throws InputDataException {
        for (Object o: br.getAllErrors()) {
            if(o instanceof FieldError) {
                FieldError fe= (FieldError) o;
                return new ErrorResponse(fe.getDefaultMessage());
            }
        }
        return roomService.save(roomRequest);
    }

    @GetMapping
    public List<RoomResponse> findAll(){
        return roomService.findAll();
    }

    @PutMapping
    public Object update(@RequestParam Long id, @RequestBody @Validated(ValidationSequence.class) RoomRequest roomRequest, BindingResult br)  {
       try{
           for (Object o: br.getAllErrors()) {
               if(o instanceof FieldError) {
                   FieldError fe= (FieldError) o;
                   return new ErrorResponse(fe.getDefaultMessage());
               }
           }
           return roomService.update(roomRequest, id);
       }catch (InputDataException ex){
           return new ErrorResponse(ex.getMessage());
       }
    }

    @DeleteMapping
    public Object delete(@RequestParam Long id) {
        try{
            roomService.delete(id);
            return "Delete room with id "+ id;
        }catch (InputDataException ex){
            return new ErrorResponse(ex.getMessage());
        }
    }

}
