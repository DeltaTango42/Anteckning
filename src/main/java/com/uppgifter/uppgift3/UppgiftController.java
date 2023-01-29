package com.uppgifter.uppgift3;

import com.uppgifter.uppgift3.model.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UppgiftController {
    EntityManagerFactory entityManagerFactory = MySQLUppgift.ENTITY_MANAGER_FACTORY;

    @FXML
    public ListView notesList;
    @FXML
    private Label welcomeText;
    private List<String> stringList = new ArrayList<>(5);

    ObservableList observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        setNotesList();
    }

    public List<Note> getAllNotes() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        List<Note> noteList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Note> allNotesQuery = entityManager.createQuery("from Note", Note.class);
            noteList = allNotesQuery.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return noteList;
    }

    public void setNotesList() {
        List<Note> notes = getAllNotes();

        for (Note note: notes) {
            stringList.add(note.getTitle());
        }

        observableList.setAll(stringList);
        notesList.setItems(observableList);
    }

    @FXML
    public void onNyAnteckningClick(ActionEvent actionEvent) {welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void onTaBortClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onUppdateraClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onNyTagClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onTaBortTagClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onNotesListClick(MouseEvent mouseEvent) {
    }
}