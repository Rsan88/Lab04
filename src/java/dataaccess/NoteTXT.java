
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
 * @author Jaren
 */
public class NoteTXT {
    
    //Content from Note text file
    private final String path;
    
    public NoteTXT(String textFilePath) {
        
        this.path = textFilePath;
    }
    
    public Note readNoteFile() throws IOException {
        
        Note readNote=null;
        String noteTitle="";
        String noteContent="";
        
        
        //Read the text file
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        // loop through the 'note.txt' file to create Notes to add to a list
        String currentLine = "";
        double lineCount = 0;
        int noteNumber = 0;
        while ((currentLine = br.readLine()) != null) {
            lineCount++;
            if ((lineCount / 2) == 0.5) {
                // First number for titles
                noteTitle = currentLine;
            } else if ((lineCount / 2) == 1.0) {
                // Second number for content
                noteNumber++;
                noteContent = currentLine;
                lineCount = 0;
                readNote = new Note(noteTitle, noteContent);
            }
        }
        br.close();
        
        return readNote;
    } // end of readNoteFile
    
    
    public void writeNote(Note edited) throws IOException {
    
        // Write new text to text file
        // to write to a fileFileWriter(path, false)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        pw.println(edited.getTitle());
        pw.print(edited.getContent());
        
        pw.close();
    } // end of writeNote
}
