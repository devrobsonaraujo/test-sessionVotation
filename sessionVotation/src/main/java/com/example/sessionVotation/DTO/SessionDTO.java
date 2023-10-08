package com.example.sessionVotation.DTO;


import jakarta.validation.constraints.NotNull;

public record SessionDTO(@NotNull String voto, @NotNull String pauta) {
}
