package com.micro.user;

public record UserService() {
    public void registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = User.builder()
                .firstName(userRegistrationRequest.firstName())
                .lastName(userRegistrationRequest.lastName())
                .email(userRegistrationRequest.email())
                .build();

        // TODO: Validation
    }
}
