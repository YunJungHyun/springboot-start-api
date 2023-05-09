package com.springboot.api.controller;


import com.springboot.api.dto.MemberDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class getController {


    private final Logger LOGGER = LoggerFactory.getLogger(getController.class);

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String getHello(){
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello World";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){

        return "Yun JungHyun !!";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{variable}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/{variable}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){ //@PathVariable(value = "variable") String var

        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
           ){


                return name+" "+email+" "+organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2&key3=value3
    @GetMapping(value = "/request2")
    public String getRequestParam2( @RequestParam Map<String,String> param){
                StringBuilder sb = new StringBuilder();
                param.entrySet().forEach(map -> {
                    sb.append(map.getKey() + " : "+ map.getValue() +"\n" );
        });

        return sb.toString();
    }
    // http://localhost:8080/api/v1/get-api/request3?key1=value1&key2=value2&key3=value3
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO){


        return memberDTO.toString();
    }

    // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request4")
    public String getRequestParam4(
            @ApiParam(value="이름", required = true)  @RequestParam String name,
            @ApiParam(value="이메일", required = true)  @RequestParam String email,
            @ApiParam(value="회사", required = true)  @RequestParam String organization
    ){


        return name+" "+email+" "+organization;
    }

}


