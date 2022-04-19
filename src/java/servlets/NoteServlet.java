
package servlets;


import java.io.IOException;
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

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        NoteTXT reader = new NoteTXT(path);  
        Note note = reader.readNoteFile();
        
        request.setAttribute("note", note);
        if(request.getParameter("edit") == null) { 
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
             return;
        } 
        else if (request.getParameter("edit").equals("")) { 
        
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
             return;
        }
       
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userTitle = request.getParameter("title");
        String userContent = request.getParameter("contents");

        Note edited = new Note(userTitle, userContent);
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        NoteTXT Reader = new NoteTXT(path);  
        
        Reader.writeNote(edited); 
        Note note = Reader.readNoteFile(); 
        request.setAttribute("note", note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
    } 
}
