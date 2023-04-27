package src.main.java.gb.app.modules.user.dto;

import java.util.List;

public record UserDTO(String login, String firstName, String lastName, List<String> authorities) {
}
