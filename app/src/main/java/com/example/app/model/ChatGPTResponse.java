package com.example.app.model;

public class ChatGPTResponse {
    public class chatgptresponse {
        private String id;
        private Object object;
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public Object getObject() {
            return object;
        }
        public void setObject(Object object) {
            this.object = object;
        }
        public String getCreated() {
            return created;
        }
        public void setCreated(String created) {
            this.created = created;
        }
        public String[] getChoices() {
            return choices;
        }
        public void setChoices(String[] choices) {
            this.choices = choices;
        }
        private String created;
        private String model;
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        private String[] choices;
    
        // Getter, Setter, Constructorなど
    }
}
