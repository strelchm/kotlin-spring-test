package ru.strelchm.kotlinspringtest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @GetMapping("/foo")
    fun foo(): String = "foo"
}

