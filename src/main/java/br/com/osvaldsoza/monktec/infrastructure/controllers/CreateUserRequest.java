package br.com.osvaldsoza.monktec.infrastructure.controllers;

public record CreateUserRequest(String username,String password,String email) {
}
