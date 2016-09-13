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
package org.jorlib.frameworks.columngeneration.branchandprice.eventhandling;

import org.jorlib.frameworks.columngeneration.branchandprice.BAPNode;

import java.util.EventObject;

/**
 * Event generated when Branch-and-Price prunes a node in the search tree
 *
 * @author Joris Kinable
 * @version 5-5-2015
 */
public class PruneNodeEvent
    extends EventObject
{

    /** Node which is being pruned **/
    public final BAPNode node;
    /** Bound on this node **/
    public final double nodeBound;
    /** Best integer solution discovered so far **/
    public final int bestIntegerSolution;

    /**
     * Creates a new PruneNodeEvent
     * 
     * @param source Generator of the event
     * @param node ID of the node being pruned
     * @param nodeBound Bound on the node
     * @param bestIntegerSolution Best integer solution discovered thus far
     */
    public PruneNodeEvent(Object source, BAPNode node, double nodeBound, int bestIntegerSolution)
    {
        super(source);
        this.node = node;
        this.nodeBound = nodeBound;
        this.bestIntegerSolution = bestIntegerSolution;
    }
}
