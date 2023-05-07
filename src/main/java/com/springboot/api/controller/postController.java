package com.springboot.api.controller;

import com.springboot.api.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class postController {

    // http://localhost:8080/api/v1/post-api/hello
    @RequestMapping(value = "/hello", method= RequestMethod.POST)
    public String getHello(){

        return "Hello POST API";
    }


    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {

            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });

            return sb.toString();
    }

    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMember2(@RequestBody MemberDTO memberDTO){

        return memberDTO.toString();
    }


}
