package com.springboot.api.controller;

import com.springboot.api.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class putController {
    // http://localhost:8080/api/v1/put-api/member
    @PutMapping(value="/member")
    public String postMember(@RequestBody Map<String, Object> putData){

        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : "+ map.getValue()+"\n");

        });
        return sb.toString();

    }

    // http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMember1(@RequestBody MemberDTO memberDTO){

        return memberDTO.toString();

        /*
        * response
            Content-Type:	text/plain;charset=UTF-8
        * */
    }
    // http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDTO postMember2(@RequestBody MemberDTO memberDTO){

        return memberDTO;

          /*
        * response
            Content-Type:	application/json
        * */
    }
}
