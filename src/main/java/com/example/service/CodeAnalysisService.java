package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class CodeAnalysisService {

    // Rule patterns for code style
    private static final Pattern CLASS_NAME_PATTERN = Pattern.compile("^[A-Z][a-zA-Z0-9]*$");
    private static final Pattern METHOD_NAME_PATTERN = Pattern.compile("^[a-z][a-zA-Z0-9]*$");
    private static final Pattern INDENTATION_PATTERN = Pattern.compile("^\s{4}.*");

    public Map<String, List<String>> analyzeCode(String code) {
        Map<String, List<String>> analysisResults = new HashMap<>();

        List<String> issues = new ArrayList<>();
        List<String> warnings = new ArrayList<>();

        String[] lines = code.split("\n");
        Pattern methodPattern = Pattern.compile("^[a-z][a-zA-Z0-9]*\\("); // Matches camelCase method names
        Pattern methodDeclarationPattern = Pattern.compile("^(public|private|protected|static|final)?\\s*([a-zA-Z0-9]+)\\s+([a-zA-Z][a-zA-Z0-9]*)\\("); // Matches method declarations

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            // Only match lines that look like method declarations
            Matcher matcher = methodDeclarationPattern.matcher(line);
            if (matcher.find()) {
                String methodName = matcher.group(3); // Extract method name from matched groups

                // Ensure the method name follows camelCase
                if (!methodPattern.matcher(methodName).matches()) {
                    issues.add("Line " + (i + 1) + ": Method name '" + methodName + "' should be camelCase.");
                }
            }

            // Check for TODO comments (as warnings)
            if (line.contains("TODO")) {
                warnings.add("Line " + (i + 1) + ": Contains TODO comment.");
            }
        }

        // Add issues and warnings to the map
        analysisResults.put("issues", issues);
        analysisResults.put("warnings", warnings);

        return analysisResults;
    }





}