/* ==========================================
 * jORLib : Java Operations Research Library
 * ==========================================
 *
 * Project Info:  http://www.coin-or.org/projects/jORLib.xml
 * Project Creator:  Joris Kinable (https://github.com/jkinable)
 *
 * (C) Copyright 2012-2016, by David Hadka and Contributors.
 *
 * This program and the accompanying materials are licensed under LGPLv2.1
 * as published by the Free Software Foundation.
 */
package org.jorlib.demo.io.tsplibreader;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.jorlib.io.tsplibreader.TSPLibInstance;
import org.jorlib.io.tsplibreader.TSPPanel;
import org.jorlib.io.tsplibreader.TSPLibTour;

/**
 * Simple class which reads a TSPLib instance and plots a solution graphically
 * 
 * @author David Hadka
 *
 */
public final class TSPGraphicalDemo
{

    public static void main(String[] args)
        throws IOException
    {
        TSPLibInstance problem = new TSPLibInstance(new File("./data/tspLib/tsp/gr120.tsp"));
        problem.addTour(new File("./data/tspLib/tsp/gr120.opt.tour"));

        TSPPanel panel = new TSPPanel(problem);

        // Display tours
        panel.displayTour(problem.getTours().get(0), Color.RED, new BasicStroke(2.0f)); // Optimal
                                                                                        // tour
        panel.displayTour(
            TSPLibTour.createRandomTour(problem.getDimension()), new Color(128, 128, 128, 64)); // Random
                                                                                                // tour

        JFrame frame = new JFrame(problem.getName());
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
