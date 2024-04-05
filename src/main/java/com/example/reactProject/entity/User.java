package com.example.reactProject.entity;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
        private String uid;
        private String pwd;
        private String uname;
        private String email;
        private LocalDate regDate;
        private int isDeleted;
        private String profile;
        private String github;
        private String insta;
        private String location;

}
