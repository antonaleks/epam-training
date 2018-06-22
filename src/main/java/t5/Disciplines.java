package t5;

public enum Disciplines {
    Programming {
        public String getClassType() {
            return "Double";
        }
    },
    Physics {
        public String getClassType() {
            return "Integer";
        }
    };

    public String getClassType() {
        return "Number";
    }

}
