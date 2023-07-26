package com.example.capstone.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    private String content;
    private String sender;
    private String receiver;
    private String time;
}
