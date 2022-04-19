
package dataaccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import models.Note;

/**
 *
 * @author Raj
 */
public class NoteTXT {

    private final String path;
    
    public NoteTXT(String textFilePath) {
        
        this.path = textFilePath;
    }
    
    public Note readNoteFile() throws IOException {
        
        Note readNote=null;
        String noteTitle="";
        String noteContent="";

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String currentLine = "";
        double lineCount = 0;
        int noteNumber = 0;
        while ((currentLine = br.readLine()) != null) {
            lineCount++;
            if ((lineCount / 2) == 0.5) {
                noteTitle = currentLine;
            } else if ((lineCount / 2) == 1.0) {
                noteNumber++;
                noteContent = currentLine;
                lineCount = 0;
                readNote = new Note(noteTitle, noteContent);
            }
        }
        br.close();
        
        return readNote;
    }
    
    
    public void writeNote(Note edited) throws IOException {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        pw.println(edited.getTitle());
        pw.print(edited.getContent());
        
        pw.close();
    } 
}
