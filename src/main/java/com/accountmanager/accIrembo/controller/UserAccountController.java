package com.accountmanager.accIrembo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.accountmanager.accIrembo.model.Response;
import com.accountmanager.accIrembo.model.UserAccount;
import com.accountmanager.accIrembo.service.userAccountService.UserAccountServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/api/userAccount")
@RequiredArgsConstructor
public class UserAccountController {
    private final UserAccountServiceImpl userAccountService;

    @GetMapping("/list")
    public ResponseEntity<Response> getUserAccount() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Account Users", userAccountService.list(30)))
                        .message("Account Users Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveUserAccount(@RequestBody UserAccount userAccount){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("server", userAccountService.create(userAccount)))
                        .message("Account User Created")
                        .status(CREATED)
                        .statusCode(CREATED.value ())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServer(@PathVariable("id ") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("server", userAccountService.get(id)))
                        .message("Account User Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUserAccount(@PathVariable("id ") Long id,@RequestBody UserAccount userAccount){
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("updated", userAccountService.update(userAccount)))
                            .message("Account User updated")
                            .status(OK)
                            .statusCode(OK.value())
                            .build()
            );

    }

    @GetMapping(path = "/Desktop/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Desktop" + "fileName"));
    }
}
