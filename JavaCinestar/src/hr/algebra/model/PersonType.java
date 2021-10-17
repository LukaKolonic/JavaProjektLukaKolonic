/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author lukak
 */
public enum PersonType {
    DIRECTOR(0),
    ACTOR(1);
    
    private final int type;

    private PersonType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
    
    public static PersonType from(int type){
        for (PersonType value : values()) {
            if (value.type==type) {
                return value;
            }
        }
         throw new RuntimeException("No such enum!");
    }
}
