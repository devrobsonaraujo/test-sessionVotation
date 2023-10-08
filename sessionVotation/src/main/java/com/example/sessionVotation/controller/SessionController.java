package com.example.sessionVotation.controller;


import com.example.sessionVotation.DTO.SessionDTO;
import com.example.sessionVotation.model.SessionModel;
import com.example.sessionVotation.repositories.SessionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/")
public class SessionController {

    @Autowired
    SessionRepository sessionRepository;

    private int wishesCont = 0;

    @GetMapping
    public ResponseEntity<String> getWelcomeMessage() {
        String message = "Bem vindo à Sessão de Votação";
        return ResponseEntity.ok(message);
    }


    @PostMapping("/schedule")
    public ResponseEntity<SessionModel> saveSession(@RequestBody@Valid SessionDTO sessionDTO) {
        LocalDateTime minuteStart = LocalDateTime.now();
        LocalDateTime minuteEnd = minuteStart.plusMinutes(1);

        System.out.println("Minuto de abertura: " + minuteStart);
        System.out.println("Minuto de fechamento: " + minuteEnd);

        var sessionModel = new SessionModel();
        BeanUtils.copyProperties(sessionDTO, sessionModel);

        wishesCont++;

        return ResponseEntity.status(HttpStatus.CREATED).body(sessionRepository.save(sessionModel));
    }

    @GetMapping("/result")
        public ResponseEntity<String> getAllSession() {
            List<SessionModel> sessions = sessionRepository.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        String sessionsJson;

        try {
            sessionsJson = objectMapper.writeValueAsString(sessions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao converter para JSON.");
        }

            String msg = "Foram cadastradas: " + wishesCont + " pautas." + " Sessao: " + sessionsJson;
            return ResponseEntity.ok(msg);
        }

}

