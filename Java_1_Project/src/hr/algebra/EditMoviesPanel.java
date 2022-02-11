/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Movie;
import hr.algebra.model.MovieTableModel;
import hr.algebra.model.Person;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author ivanm
 */
public class EditMoviesPanel extends javax.swing.JPanel {

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private static final String DIR = "assets";

    private Repository repository;
    private MovieTableModel moviesTableModel;

    private Movie selectedMovie;

    /**
     * Creates new form EditMoviesPanel
     */
    public EditMoviesPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        tfOriginalTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();
        tfPublishedDate = new javax.swing.JTextField();
        btnAddMovie = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsActors = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        btnDeleteActor = new javax.swing.JButton();
        btnChooseImage = new javax.swing.JButton();
        btnDeleteMovie = new javax.swing.JButton();
        btnUpdateMovie = new javax.swing.JButton();
        tfPicturePath = new javax.swing.JTextField();
        btnAddActor = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfDirectors = new javax.swing.JTextField();
        tfGenre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfDuration = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMovies = new javax.swing.JTable();
        lblTitleError = new javax.swing.JLabel();
        lblOriginalTitleError = new javax.swing.JLabel();
        lblDescriptionError = new javax.swing.JLabel();
        lblPublishedDateError = new javax.swing.JLabel();
        lblPictureError = new javax.swing.JLabel();
        lblDirectorError = new javax.swing.JLabel();
        lblGenreError = new javax.swing.JLabel();
        lblDurationError = new javax.swing.JLabel();
        tfLink = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setName("Edit Movies"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Title");

        jLabel2.setText("Original title");

        jLabel3.setText("Description");

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        jLabel4.setText("Published date");

        lblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        lblPicture.setText("jLabel5");

        tfPublishedDate.setName("Date"); // NOI18N

        btnAddMovie.setBackground(new java.awt.Color(0, 153, 0));
        btnAddMovie.setText("Add");
        btnAddMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMovieActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lsActors);

        jLabel6.setText("Actors");

        btnDeleteActor.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteActor.setText("Delete");
        btnDeleteActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActorActionPerformed(evt);
            }
        });

        btnChooseImage.setText("Choose image");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        btnDeleteMovie.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteMovie.setText("Delete");
        btnDeleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMovieActionPerformed(evt);
            }
        });

        btnUpdateMovie.setBackground(new java.awt.Color(255, 153, 0));
        btnUpdateMovie.setText("Update");
        btnUpdateMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMovieActionPerformed(evt);
            }
        });

        btnAddActor.setText("Add");
        btnAddActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActorActionPerformed(evt);
            }
        });

        jLabel7.setText("Directors");

        jLabel8.setText("Genre");

        tfGenre.setText("zanr");

        jLabel9.setText("Duration");

        tbMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        tbMovies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbMoviesKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbMovies);

        lblTitleError.setForeground(new java.awt.Color(255, 0, 0));

        lblOriginalTitleError.setForeground(new java.awt.Color(255, 0, 0));

        lblDescriptionError.setForeground(new java.awt.Color(255, 0, 0));

        lblPublishedDateError.setForeground(new java.awt.Color(255, 0, 0));

        lblPictureError.setForeground(new java.awt.Color(255, 0, 0));

        lblDirectorError.setForeground(new java.awt.Color(255, 0, 0));

        lblGenreError.setForeground(new java.awt.Color(255, 0, 0));

        lblDurationError.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setText("Link");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnAddMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDeleteMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                        .addComponent(btnUpdateMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfPublishedDate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfOriginalTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTitle, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTitleError)
                                            .addComponent(lblOriginalTitleError)
                                            .addComponent(lblDescriptionError)
                                            .addComponent(lblPublishedDateError))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(36, 36, 36))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(4, 4, 4)))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfDirectors, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lblDirectorError)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lblGenreError)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDurationError)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAddActor)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnDeleteActor))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15))
                                    .addComponent(jLabel5))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfLink)
                                    .addComponent(lblPicture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(lblPictureError)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnChooseImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfOriginalTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblOriginalTitleError))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTitleError)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescriptionError)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeleteActor)
                        .addComponent(btnChooseImage)
                        .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddActor)
                        .addComponent(lblPictureError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfPublishedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPublishedDateError))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfLink))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMovie)
                    .addComponent(btnDeleteMovie)
                    .addComponent(btnUpdateMovie)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(tfDirectors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDirectorError)
                    .addComponent(lblGenreError)
                    .addComponent(lblDurationError))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            init();
        } catch (Exception ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Cannot load form");
            System.exit(1);
        }
    }//GEN-LAST:event_formComponentShown

    private void tbMoviesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbMoviesKeyReleased
        try {
            showMovie();
        } catch (Exception ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Cannot load Movie");
        }
    }//GEN-LAST:event_tbMoviesKeyReleased

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
        try {
            showMovie();
        } catch (Exception ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Cannot load Movie");
        }
    }//GEN-LAST:event_tbMoviesMouseClicked

    private void btnDeleteMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMovieActionPerformed

        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose movie to delete");
            return;
        }
        if (MessageUtils.showConfirmDialog(
                "Delete movie",
                "Do you really want to delete movie?") == JOptionPane.YES_OPTION) {
            try {
                if (selectedMovie.getPicturePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedMovie.getPicturePath()));
                }
                repository.deleteMovie(selectedMovie.getId());
                moviesTableModel.setMovies(repository.selectMovies());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete movie, please try later!");
            }
        }
    }//GEN-LAST:event_btnDeleteMovieActionPerformed

    private void btnAddMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMovieActionPerformed
        if (formValid()) {
            try {
                String localPicturePath = uploadPicture();
                Movie movie = new Movie(
                        tfTitle.getText().trim(),
                        tfOriginalTitle.getText().trim(),
                        taDescription.getText().trim(),
                        localPicturePath,
                        Integer.parseInt(tfDuration.getText().trim()),
                        tfGenre.getText().trim(),
                        tfLink.getText().trim(),
                        LocalDateTime.parse(tfPublishedDate.getText().trim(), Movie.DATE_FORMATTER)
                );
                setPersonsForBase(movie);
                repository.addMovie(movie);
                moviesTableModel.setMovies(repository.selectMovies());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to create movie!");
            }
        }
    }//GEN-LAST:event_btnAddMovieActionPerformed

    private void btnUpdateMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMovieActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to update");
            return;
        }
        if (formValid()) {
            try {
                if (!tfPicturePath.getText().trim().equals(selectedMovie.getPicturePath().trim())) {

                    Files.deleteIfExists(Paths.get(selectedMovie.getPicturePath()));

                    String localPicturePath = uploadPicture();
                    selectedMovie.setPicturePath(localPicturePath);
                }

                selectedMovie.setTitle(tfTitle.getText().trim());
                selectedMovie.setOriginalTitle(tfOriginalTitle.getText().trim());
                selectedMovie.setLink(tfLink.getText().trim());
                selectedMovie.setGenre(tfGenre.getText().trim());
                selectedMovie.setLength(Integer.parseInt(tfDuration.getText().trim()));
                selectedMovie.setDescription(taDescription.getText().trim());
                selectedMovie.setPublishedDate(LocalDateTime.parse(tfPublishedDate.getText().trim(), Movie.DATE_FORMATTER));

                setPersonsForBase(selectedMovie);
                repository.updateMovie(selectedMovie.getId(), selectedMovie);
                moviesTableModel.setMovies(repository.selectMovies());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to update movie!");
            }
        }
    }//GEN-LAST:event_btnUpdateMovieActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        Optional<File> otpFile = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (otpFile.isPresent()) {
            File file = otpFile.get();
            if (file == null) {
                return;
            }
            tfPicturePath.setText(file.getAbsolutePath());
            try {
                setIcon(lblPicture, file);
            } catch (IOException ex) {
                Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to get picture!");
            }
        }

    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void btnAddActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActorActionPerformed

        String name = JOptionPane.showInputDialog(this, "Enter Name");
        if (name != null && !name.isEmpty()) {
            addNewActor(name);
        }
    }//GEN-LAST:event_btnAddActorActionPerformed

    private void btnDeleteActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActorActionPerformed
        DefaultListModel<Person> model = (DefaultListModel<Person>) lsActors.getModel();
        if (lsActors.getSelectedIndex() != -1) {
            model.remove(lsActors.getSelectedIndex());
            lsActors.setModel(model);
        }

    }//GEN-LAST:event_btnDeleteActorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddActor;
    private javax.swing.JButton btnAddMovie;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDeleteActor;
    private javax.swing.JButton btnDeleteMovie;
    private javax.swing.JButton btnUpdateMovie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblDirectorError;
    private javax.swing.JLabel lblDurationError;
    private javax.swing.JLabel lblGenreError;
    private javax.swing.JLabel lblOriginalTitleError;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblPictureError;
    private javax.swing.JLabel lblPublishedDateError;
    private javax.swing.JLabel lblTitleError;
    private javax.swing.JList<Person> lsActors;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tbMovies;
    private javax.swing.JTextField tfDirectors;
    private javax.swing.JTextField tfDuration;
    private javax.swing.JTextField tfGenre;
    private javax.swing.JTextField tfLink;
    private javax.swing.JTextField tfOriginalTitle;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfPublishedDate;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

    private void init() throws Exception {
        initValidation();
        initRepository();
        initTable();
        initButtons(false);
        tfLink.setEditable(false);
        tfPicturePath.setEnabled(false);

    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setAutoCreateRowSorter(true);
        tbMovies.setRowHeight(25);
        moviesTableModel = new MovieTableModel(repository.selectMovies());
        tbMovies.setModel(moviesTableModel);
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfTitle, tfOriginalTitle, taDescription, tfPublishedDate, tfDirectors, tfGenre, tfDuration, tfPicturePath);
        errorLabels = Arrays.asList(lblTitleError, lblOriginalTitleError, lblDescriptionError, lblPublishedDateError, lblDirectorError, lblGenreError, lblDurationError, lblPictureError);
    }

    private void showMovie() throws Exception {
        clearForm();
        int selectedRow = tbMovies.getSelectedRow();
        int rowIndex = tbMovies.convertRowIndexToModel(selectedRow);
        int selectedMoviesId = (int) moviesTableModel.getValueAt(rowIndex, 0);

        selectedMovie = repository.selectMovie(selectedMoviesId);
        try {
            fillForm(selectedMovie);
            initButtons(true);
        } catch (IOException ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show movie!");
        }
    }

    private void clearForm() {
        validationFields.forEach(e -> e.setText(""));
        errorLabels.forEach(e -> e.setText(""));
        lblPicture.setIcon(new ImageIcon(getClass().getResource("/assets/no_image.png")));

        tfLink.setText("");
        lsActors.setModel(new DefaultListModel<>());

        selectedMovie = null;
        btnChooseImage.setEnabled(false);
    }

    private void fillForm(Movie movie) throws IOException {

        DefaultListModel<Person> listModel = new DefaultListModel<>();
        if (movie.getActors() != null) {
            movie.getActors().forEach(a -> listModel.addElement(a));
        }

        if (movie.getPicturePath() != null && Files.exists(Paths.get(movie.getPicturePath()))) {
            tfPicturePath.setText(movie.getPicturePath());
            setIcon(lblPicture, new File(movie.getPicturePath()));
        }
        tfTitle.setText(movie.getTitle());
        tfOriginalTitle.setText(movie.getOriginalTitle());
        tfLink.setText(movie.getLink());
        taDescription.setText(movie.getDescription());
        tfDirectors.setText(movie.getDirectors().toString());
        lsActors.setModel(listModel);
        tfGenre.setText(movie.getGenre());
        tfDuration.setText(String.valueOf(movie.getLength()));
        tfPublishedDate.setText(movie.getPublishedDate().format(Movie.DATE_FORMATTER));
    }

    private void setIcon(JLabel label, File file) throws IOException {
        label.setIcon(IconUtils.createIcon(file.getAbsolutePath(), label.getWidth(), label.getHeight()));
    }

    private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");

            if ("Date".equals(validationFields.get(i).getName())) {
                try {
                    LocalDateTime.parse(validationFields.get(i).getText().trim(), Movie.DATE_FORMATTER);
                    errorLabels.get(i).setText("");
                } catch (Exception e) {
                    ok = false;
                    errorLabels.get(i).setText("X");
                }
            }
        }

        return ok;
    }

    private String uploadPicture() throws IOException {
        String picturePath = tfPicturePath.getText().trim();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

    private void setPersonsForBase(Movie movie) {
        ListModel<Person> actorsModel = lsActors.getModel();
        List<Person> actors = new ArrayList<>();

        for (int i = 0; i < actorsModel.getSize(); i++) {
            Person person = actorsModel.getElementAt(i);
            actors.add(person);
        }
        movie.setActors(actors);

        String[] directorsInString = tfDirectors.getText().trim().split(",");

        List<Person> directors = new ArrayList<>();

        for (int i = 0; i < directorsInString.length; i++) {

            String d = directorsInString[i].replace("[", "");
            d = d.replace("]", "");

            Person director = new Person(d.substring(0, d.indexOf(" ")).trim(), d.substring(d.indexOf(" ") + 1).trim(), true);
            directors.add(director);
        }

        movie.setDirectors(directors);

    }

    private void addNewActor(String name) {

        name = name.trim();

        if (name.split(" ").length == 1) {
            setActorsModel(name.trim(), new String());
        } else {
            setActorsModel(name.substring(0, name.indexOf(" ")).trim(), name.substring(name.indexOf(" ") + 1).trim());
        }
    }

    private void initButtons(boolean mode) {

        btnChooseImage.setEnabled(mode);
        btnAddActor.setEnabled(mode);
        btnDeleteActor.setEnabled(mode);
    }

    private void setActorsModel(String firstName, String lastName) {
        Person person = new Person(firstName, lastName, false, selectedMovie.getId());
        DefaultListModel<Person> model = (DefaultListModel<Person>) lsActors.getModel();

        model.addElement(person);

        lsActors.setModel(model);
    }
}
