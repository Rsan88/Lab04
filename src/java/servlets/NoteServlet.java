
package servlets;


import java.io.IOException;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import dataaccess.NoteTXT;


public class NoteServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Content from Note text file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        NoteTXT noteReader = new NoteTXT(path);  
        Note note = noteReader.readNoteFile();
        
        request.setAttribute("note", note);
        
        if(request.getParameter("edit") == null) { //Display view note page
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        } 
        else if (request.getParameter("edit").equals("")) { // Display edit note page
        
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        return;
    } // end of doGet


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userTitle = request.getParameter("title");
        String userContent = request.getParameter("contents");

        
        Note edited = new Note(userTitle, userContent);
        
        // Content from Note text file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        NoteTXT noteReader = new NoteTXT(path);  
        
        noteReader.writeNote(edited); //save the changes
        
        Note note = noteReader.readNoteFile(); //retrieve the new note
        
        request.setAttribute("note", note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
    } // end of doPost
    
}
