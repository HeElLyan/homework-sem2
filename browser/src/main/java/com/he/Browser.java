package com.he;

public class Browser {
    private Page currentPage;

    public Browser(Page currentPage) {
        this.currentPage = currentPage;
    }

    public static class Current {
        private Page currentPage;

        Current(Page currentPage) {
            this.currentPage = currentPage;
        }

        Page getCurrentPage() {
            return currentPage;
        }
    }

    public Current save(){
        return new Current(currentPage);
    }

    public void restore(Current Current){
        currentPage = Current.getCurrentPage();
    }

    public Page getCurrentPage() {
        return currentPage;
    }
}
