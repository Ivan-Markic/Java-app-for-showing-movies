/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.dal.file.FileRepository;
import hr.algebra.model.FavouriteMovies;
import hr.algebra.model.Movie;
import hr.algebra.model.MovieTransferable;
import hr.algebra.utils.JAXBUtils;
import hr.algebra.utils.MessageUtils;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.xml.bind.JAXBException;

/**
 *
 * @author ivanm
 */
public class FavouriteMoviesPanel extends javax.swing.JPanel {

    private static final String FILENAME = "assets/favouriteMovies.xml";
    private Repository repository;
    private final List<Movie> favouriteMovies = new ArrayList<>();
    private List<Movie> allMovies;

    /**
     * Creates new form FavouriteMoviesPanel
     */
    public FavouriteMoviesPanel(){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lsAllMovies = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsFavouriteMovies = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSaveXml = new javax.swing.JButton();
        btnSaveTxt = new javax.swing.JButton();

        setName("Favourite Movies"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jScrollPane1.setViewportView(lsAllMovies);

        jScrollPane2.setViewportView(lsFavouriteMovies);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Favourite movies");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("All movies");

        btnSaveXml.setBackground(new java.awt.Color(255, 0, 0));
        btnSaveXml.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSaveXml.setText("Save favourite movies in xml file");
        btnSaveXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveXmlActionPerformed(evt);
            }
        });

        btnSaveTxt.setBackground(new java.awt.Color(255, 0, 0));
        btnSaveTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSaveTxt.setText("Save favourite movies in txt file");
        btnSaveTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveXml, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnSaveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)
                        .addComponent(btnSaveXml, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveXmlActionPerformed

        try {
            JAXBUtils.save(new FavouriteMovies(favouriteMovies), FILENAME);
            MessageUtils.showInformationMessage("Information", "Data stored in xml file");
        } catch (JAXBException ex) {
            Logger.getLogger(FavouriteMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to save data");
        }

    }//GEN-LAST:event_btnSaveXmlActionPerformed

    private void btnSaveTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTxtActionPerformed
        try {
            FileRepository fileRepository = new FileRepository();
            fileRepository.writeMovies(favouriteMovies);
            MessageUtils.showInformationMessage("Information", "Data stored in txt file");
            
        } catch (IOException ex) {
            Logger.getLogger(FavouriteMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveTxtActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            initRepository();
            initList();
            loadMovies();
            initDragAndDrop();
        } catch (Exception ex) {
            Logger.getLogger(FavouriteMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to load favourite movies");
        }

    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveTxt;
    private javax.swing.JButton btnSaveXml;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Movie> lsAllMovies;
    private javax.swing.JList<Movie> lsFavouriteMovies;
    // End of variables declaration//GEN-END:variables

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void loadMovieModel() {
        

        DefaultListModel<Movie> favouriteMovieModel = new DefaultListModel<>();

        favouriteMovies.forEach(favouriteMovieModel::addElement);
        lsFavouriteMovies.setModel(favouriteMovieModel);

        DefaultListModel<Movie> movieModel = new DefaultListModel<>();

        if (favouriteMovies.size() > 0) {
            allMovies.remove(favouriteMovies.get(favouriteMovies.size() - 1));
        }

        allMovies.forEach(movieModel::addElement);

        lsAllMovies.setModel(movieModel);

    }

    private void initDragAndDrop() {
        lsAllMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsAllMovies.setDragEnabled(true);
        lsAllMovies.setTransferHandler(new ExportTransferHandler());

        lsFavouriteMovies.setDropMode(DropMode.ON);
        lsFavouriteMovies.setTransferHandler(new ImportTransferHandler());
    }

    private void initList() throws Exception {
        DefaultListModel<Movie> movieModel = new DefaultListModel<>();

        allMovies = repository.selectMovies();

        allMovies.forEach(m -> movieModel.addElement(m));

        lsAllMovies.setModel(movieModel);
    }

    private void loadMovies() {
        try {
            favouriteMovies.clear();
            if (new File(FILENAME).exists()) {
                FavouriteMovies moviesFromFile = (FavouriteMovies) JAXBUtils.load(FavouriteMovies.class, FILENAME);
                favouriteMovies.addAll(moviesFromFile.getMovies());
                allMovies.removeAll(favouriteMovies);
            }
            loadMovieModel();

        } catch (JAXBException ex) {
            Logger.getLogger(FavouriteMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to load movies");
        }
    }

    private class ExportTransferHandler extends TransferHandler {

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new MovieTransferable(lsAllMovies.getSelectedValue());
        }

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

    }

    private class ImportTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(MovieTransferable.MOVIE_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {
            Transferable transferable = support.getTransferable();
            try {
                Movie add = (Movie) transferable.getTransferData(MovieTransferable.MOVIE_FLAVOR);
                favouriteMovies.add(add);
                loadMovieModel();
                return true;

            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(FavouriteMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

    }
}
