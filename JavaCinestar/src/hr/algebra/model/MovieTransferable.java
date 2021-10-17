/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author lukak
 */
public class MovieTransferable implements Transferable{
    private final Movie data;
    
    public static final DataFlavor MOVIE_FLAVOR = new DataFlavor(Movie.class, "Movie");
    public static final DataFlavor[] SUPPORTED_FLAVORS = { MOVIE_FLAVOR };

    public MovieTransferable(Movie data) {
        this.data = data;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
         return flavor.equals(MOVIE_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
         if(isDataFlavorSupported(flavor)) {
            return data;
        }
        throw new UnsupportedFlavorException(flavor); //To change body of generated methods, choose Tools | Templates.
    }
}
