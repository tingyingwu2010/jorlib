/* ==========================================
 * jORLib : Java Operations Research Library
 * ==========================================
 *
 * Project Info:  http://www.coin-or.org/projects/jORLib.xml
 * Project Creator:  Joris Kinable (https://github.com/jkinable)
 *
 * (C) Copyright 2015-2016, by Joris Kinable and Contributors.
 *
 * This program and the accompanying materials are licensed under LGPLv2.1
 * as published by the Free Software Foundation.
 */
package org.jorlib.frameworks.columngeneration.master.cutGeneration;

/**
 * Class representing a valid inequality.
 *
 * @author Joris Kinable
 * @version 13-4-2015
 *
 */
public abstract class AbstractInequality
{

    /**
     * Reference to the AbstractCutGenerator which generates inequalities of the type that extends
     * this class
     **/
    public final AbstractCutGenerator maintainingGenerator;

    /**
     * Creates a new inequality
     * 
     * @param maintainingGenerator Reference to the AbstractCutGenerator which generates
     *        inequalities of the type that extends this class
     */
    public AbstractInequality(AbstractCutGenerator maintainingGenerator)
    {
        this.maintainingGenerator = maintainingGenerator;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

}
