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
package org.jorlib.frameworks.columngeneration.tsp.bap;

import org.jorlib.frameworks.columngeneration.branchandprice.AbstractBranchAndPrice;
import org.jorlib.frameworks.columngeneration.branchandprice.AbstractBranchCreator;
import org.jorlib.frameworks.columngeneration.branchandprice.BAPNode;
import org.jorlib.frameworks.columngeneration.pricing.AbstractPricingProblemSolver;
import org.jorlib.frameworks.columngeneration.tsp.cg.Matching;
import org.jorlib.frameworks.columngeneration.tsp.cg.PricingProblemByColor;
import org.jorlib.frameworks.columngeneration.tsp.cg.master.Master;
import org.jorlib.frameworks.columngeneration.tsp.model.TSP;

import java.util.Arrays;
import java.util.List;

/**
 * Branch-and-Price class
 *
 * @author Joris Kinable
 * @version 22-4-2015
 */
public final class BranchAndPrice
    extends AbstractBranchAndPrice<TSP, Matching, PricingProblemByColor>
{

    public BranchAndPrice(
        TSP modelData, Master master, List<PricingProblemByColor> pricingProblems,
        List<Class<
            ? extends AbstractPricingProblemSolver<TSP, Matching, PricingProblemByColor>>> solvers,
        List<? extends AbstractBranchCreator<TSP, Matching, PricingProblemByColor>> branchCreators,
        int objectiveInitialSolution, List<Matching> initialSolution)
    {
        super(
            modelData, master, pricingProblems, solvers, branchCreators, 0,
            objectiveInitialSolution);
        this.warmStart(objectiveInitialSolution, initialSolution);
    }

    /**
     * Generates an artificial solution. Columns in the artificial solution are of high cost such
     * that they never end up in the final solution if a feasible solution exists, since any
     * feasible solution is assumed to be cheaper than the artificial solution. The artificial
     * solution is used to guarantee that the master problem has a feasible solution.
     *
     * @return artificial solution
     */
    @Override
    protected List<Matching> generateInitialFeasibleSolution(BAPNode<TSP, Matching> node)
    {
        Matching matching1 = new Matching(
            "Artificial", true, pricingProblems.get(0), incumbentSolution.get(0).edges,
            incumbentSolution.get(0).succ, objectiveIncumbentSolution);
        Matching matching2 = new Matching(
            "Artificial", true, pricingProblems.get(1), incumbentSolution.get(1).edges,
            incumbentSolution.get(1).succ, objectiveIncumbentSolution);
        return Arrays.asList(matching1, matching2);
    }

    /**
     * Checks whether the given solution is integer
     * 
     * @param node node
     * @return true if the solution is an integer solution
     */
    @Override
    protected boolean isIntegerNode(BAPNode<TSP, Matching> node)
    {
        return node.getSolution().size() == 2;
    }
}
