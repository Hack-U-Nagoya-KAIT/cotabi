package com.example.app.model;

public class ChatGPTRequest {
    public class chatgptrequest {
        private String prompt;
        private int maxTokens;
        private double temperature;
        private int topP;
        public String getPrompt() {
            return prompt;
        }
        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }
        public int getMaxTokens() {
            return maxTokens;
        }
        public void setMaxTokens(int maxTokens) {
            this.maxTokens = maxTokens;
        }
        public double getTemperature() {
            return temperature;
        }
        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }
        public int getTopP() {
            return topP;
        }
        public void setTopP(int topP) {
            this.topP = topP;
        }
    
        // Getter, Setter, Constructorなど
    }
    
    
}
