/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Raj
 */
public class Note {
    
    private String title;
    private String content;
    
    public Note() {
    }
    
    public Note(String noteTitle, String noteContent) {
    
        this.title = noteTitle;
        this.content = noteContent;
    }
    

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
