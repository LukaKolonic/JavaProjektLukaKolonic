/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra;

import hr.algebra.dal.RepoFactory;
import hr.algebra.dal.Repository;
import hr.algebra.model.Genre;
import hr.algebra.model.Movie;
import hr.algebra.model.MovieTableModel;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author lukak
 */
public class EditMoviesPanel extends javax.swing.JPanel {
    
    private static final String DIR = "assets";
    
    private List<JTextComponent> validationFields;
    private List<JLabel> errorlabels;
    
    private Repository movieRepo;
    
    private MovieTableModel movieTableModel;
    
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

        lbIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfTrailer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPubdate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDuration = new javax.swing.JTextField();
        tfPoster = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfOrigTitle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfRating = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        tfGenre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfBooking = new javax.swing.JTextField();
        lbTitleError = new javax.swing.JLabel();
        lbOrigTitleError = new javax.swing.JLabel();
        lbPubdateError = new javax.swing.JLabel();
        lbDurationError = new javax.swing.JLabel();
        lbRatingError = new javax.swing.JLabel();
        lbYearError = new javax.swing.JLabel();
        lbBookingError = new javax.swing.JLabel();
        lbDateError = new javax.swing.JLabel();
        lbGenreError = new javax.swing.JLabel();
        lbTrailerError = new javax.swing.JLabel();
        lbPosterError = new javax.swing.JLabel();
        lbDescError = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnChoose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMovies = new javax.swing.JTable();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N

        jLabel1.setText("Title");

        jLabel2.setText("Pub date");

        jLabel3.setText("Orig title");

        tfPubdate.setName("Date"); // NOI18N

        jLabel4.setText("Duration");

        jLabel5.setText("Year");

        jLabel6.setText("Rating");

        jLabel7.setText("Genre");

        jLabel8.setText("Date");

        jLabel9.setText("Description");

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        jLabel10.setText("Booking");

        jLabel11.setText("Trailer");

        lbTitleError.setForeground(java.awt.Color.red);

        lbOrigTitleError.setForeground(java.awt.Color.red);

        lbPubdateError.setForeground(java.awt.Color.red);

        lbDurationError.setForeground(java.awt.Color.red);

        lbRatingError.setForeground(java.awt.Color.red);

        lbYearError.setForeground(java.awt.Color.red);

        lbBookingError.setForeground(java.awt.Color.red);

        lbDateError.setForeground(java.awt.Color.red);

        lbGenreError.setForeground(java.awt.Color.red);

        lbTrailerError.setForeground(java.awt.Color.red);

        lbPosterError.setForeground(java.awt.Color.red);

        lbDescError.setForeground(java.awt.Color.red);

        btnUpdate.setForeground(new java.awt.Color(0, 153, 0));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setForeground(java.awt.Color.red);
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setForeground(java.awt.Color.blue);
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tbMovies);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbDateError))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbTitleError))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfPubdate, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbPubdateError))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfOrigTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbOrigTitleError))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfRating, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbRatingError))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbYearError))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbDurationError)))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbDescError))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tfTrailer)
                                                        .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(tfBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbTrailerError)
                                            .addComponent(lbGenreError)
                                            .addComponent(lbBookingError)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfPoster)
                                .addGap(18, 18, 18)
                                .addComponent(btnChoose))
                            .addComponent(lbIcon))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPosterError, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbIcon))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lbPosterError, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPoster, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfPubdate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbPubdateError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOrigTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOrigTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDescError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDurationError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbYearError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfRating, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbRatingError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDateError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbBookingError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTrailerError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbGenreError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        Optional<File> file = FileUtils.uploadFile("Images", "png", "jpg", "jpeg");
        if(!file.isPresent()){
            return;
        }
        tfPoster.setText(file.get().getAbsolutePath());
        setIcon(lbIcon, file.get());
    }//GEN-LAST:event_btnChooseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (formValid()) {
            try {
                String path = uploadPicture();
                Movie movie = new Movie(
                        tfTitle.getText().trim(),
                        LocalDateTime.parse(tfPubdate.getText().trim(), Movie.DATE_FORMATTER),
                        taDescription.getText().trim(),
                        tfOrigTitle.getText().trim(),
                        Integer.parseInt(tfDuration.getText().trim()),
                        Integer.parseInt(tfYear.getText().trim()),
                        path,
                        Integer.parseInt(tfRating.getText().trim()),
                        tfBooking.getText().trim(),
                        tfDate.getText().trim(),
                        tfTrailer.getText().trim(),
                        new Genre(tfGenre.getText().trim()));

                movieRepo.create(movie);
                movieTableModel.setMovies(movieRepo.select());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
       showMovie();
    }//GEN-LAST:event_tbMoviesMouseClicked

    private void tbMoviesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbMoviesKeyReleased
       showMovie();
    }//GEN-LAST:event_tbMoviesKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong", "Select movie!");
            return;
        }

        if (formValid()) {
            try { 
               
                 if (!tfPoster.getText().trim().equals(selectedMovie.getPoster())) {
                    if (selectedMovie.getPoster()!= null) {
                        Files.deleteIfExists(Paths.get(selectedMovie.getPoster()));
                    }
                    String path = uploadPicture();
                    selectedMovie.setPoster(path);
                }
                
                
                
                selectedMovie.setTitle(tfTitle.getText().trim());
                selectedMovie.setPubDate(LocalDateTime.parse(tfPubdate.getText().trim(), Movie.DATE_FORMATTER));
                selectedMovie.setDescription(taDescription.getText().trim());
                selectedMovie.setOrigTitle(tfOrigTitle.getText().trim());
                selectedMovie.setDuration(Integer.parseInt(tfDuration.getText().trim()));
                selectedMovie.setYear(Integer.parseInt(tfYear.getText().trim()));
                selectedMovie.setRating(Integer.parseInt(tfRating.getText().trim()));
                selectedMovie.setBooking(tfBooking.getText().trim());
                selectedMovie.setDate(tfDate.getText().trim());
                selectedMovie.setTrailer(tfTrailer.getText().trim());
                selectedMovie.setGenre(new Genre(tfGenre.getText().trim()));
                
               

                movieRepo.update(selectedMovie.getId(), selectedMovie);
                movieTableModel.setMovies(movieRepo.select());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Wrong", "It is impossible to update movie!");
            }
        }
          
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong", "Select movie!");
            return;
        }
       
        if(MessageUtils.showConfirmDialog("Delete", "Are you sure?") == JOptionPane.YES_OPTION) {
            try {
                if(selectedMovie.getPoster()!= null) {
                    Files.deleteIfExists(Paths.get(selectedMovie.getPoster()));
                }
                movieRepo.delete(selectedMovie.getId());
                movieTableModel.setMovies(movieRepo.select());
                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Can't delete person!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel lbBookingError;
    private javax.swing.JLabel lbDateError;
    private javax.swing.JLabel lbDescError;
    private javax.swing.JLabel lbDurationError;
    private javax.swing.JLabel lbGenreError;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbOrigTitleError;
    private javax.swing.JLabel lbPosterError;
    private javax.swing.JLabel lbPubdateError;
    private javax.swing.JLabel lbRatingError;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JLabel lbTrailerError;
    private javax.swing.JLabel lbYearError;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tbMovies;
    private javax.swing.JTextField tfBooking;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDuration;
    private javax.swing.JTextField tfGenre;
    private javax.swing.JTextField tfOrigTitle;
    private javax.swing.JTextField tfPoster;
    private javax.swing.JTextField tfPubdate;
    private javax.swing.JTextField tfRating;
    private javax.swing.JTextField tfTitle;
    private javax.swing.JTextField tfTrailer;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables

    private void init() {
         try {
            initValidation();
            initRepository();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to load");
            System.exit(1);
        }
    }
    
     private void initValidation() {
        validationFields = Arrays.asList(tfTitle,tfPubdate,taDescription,tfOrigTitle,tfDuration,tfYear,tfPoster,tfRating,tfBooking,tfDate,tfTrailer,tfGenre);
        errorlabels = Arrays.asList(lbTitleError,lbPubdateError,lbDescError,lbOrigTitleError,lbDurationError,lbYearError,lbPosterError,lbRatingError, lbBookingError,lbDateError,lbTrailerError,lbGenreError);
    }

    private void initRepository() throws Exception {
        movieRepo = RepoFactory.getMovieRepo();
    }

    private void initTable() throws Exception {
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setAutoCreateRowSorter(true);
        tbMovies.setRowHeight(25);

        movieTableModel = new MovieTableModel(movieRepo.select());
        tbMovies.setModel(movieTableModel);

       
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Broken image");
        }
    }

    private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorlabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
            
              if("Date".equals(validationFields.get(i).getName())) {
                try {
                    LocalDateTime.parse(validationFields.get(i).getText().trim(), Movie.DATE_FORMATTER);
                    errorlabels.get(i).setText("");
                } catch (Exception e) {
                    errorlabels.get(i).setText("X");
                    ok = false;
                }
            }
        }
        return ok;
        
    }
    
    
    private String uploadPicture() throws IOException {
        
        String pictureUrl = tfPoster.getText().trim();
        String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String picturePath = DIR + File.separator + pictureName;
        FileUtils.copy(pictureUrl, picturePath);
        
        return picturePath;
    }

    private void clearForm() {
        validationFields.forEach(e -> e.setText(""));
        errorlabels.forEach(e -> e.setText(""));
        
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        selectedMovie = null;
        
                
                
    }

    private void showMovie() {
        int selectedRow = tbMovies.getSelectedRow();
        int rowIndex = tbMovies.convertRowIndexToModel(selectedRow); //soritranje
        int id = (int)movieTableModel.getValueAt(rowIndex, 0);
        
         try {
            Optional<Movie> optMovie = movieRepo.select(id);
            if(optMovie.isPresent()){
                selectedMovie = optMovie.get();
                FillForm(selectedMovie);
            }
        } catch (Exception ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void FillForm(Movie movie) {
        tfTitle.setText(movie.getTitle());
        tfPubdate.setText(movie.getPubDate().format(Movie.DATE_FORMATTER));
        taDescription.setText(movie.getDescription());
        tfOrigTitle.setText(movie.getOrigTitle());
        tfDuration.setText(String.valueOf(movie.getDuration()));
        tfYear.setText(String.valueOf(movie.getYear()));
        tfRating.setText(String.valueOf(movie.getRating()));
        tfBooking.setText(movie.getBooking());
        tfDate.setText(movie.getDate());
        tfTrailer.setText(movie.getTrailer());
        tfGenre.setText(movie.getGenre().toString());
        
         if(movie.getPoster()!= null) {
            tfPoster.setText(movie.getPoster());
            setIcon(lbIcon, new File(movie.getPoster()));
        }
    }

    
}