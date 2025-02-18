package com.example.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.CodeAnalysisService;


@Controller
public class HomeController {
    @Autowired
    CodeAnalysisService codeAnalysisService;    


    @GetMapping("/")
    public String showUploadForm() {
        return "index";
    }
    
    @PostMapping("/upload")
public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
    // Convert file content to a string
    String content = new String(file.getBytes(), StandardCharsets.UTF_8);
    
    // Call the updated analyzeCode method
    Map<String, List<String>> analysisResults = codeAnalysisService.analyzeCode(content);
    
    // Add the analysis results to the model
    model.addAttribute("results", analysisResults);
    
    // Return the view name to display the results
    return "results";
}
}
