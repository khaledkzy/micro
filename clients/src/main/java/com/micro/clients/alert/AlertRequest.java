package com.micro.clients.alert;

public record AlertRequest(Integer toMemberId,
                           String toMemberName,
                           String alertText) {

}
