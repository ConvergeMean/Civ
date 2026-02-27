package com.github.igotyou.FactoryMod.recipes;

import java.util.Locale;

/**
 * Holds per-recipe improvement modifiers for a factory instance.
 * Factors are stored with 1 decimal precision. Applied last (after ProductionRecipeModifier).
 * Hard caps are applied via FactoryModManager from config.yml.
 */
public class RecipeImprovement {

    private double inputFactor;
    private double outputFactor;
    private double charcoalFactor;
    private double timeFactor;
    private int improvementCount;

    public RecipeImprovement() {
        this(1.0, 1.0, 1.0, 1.0, 0);
    }

    public RecipeImprovement(double inputFactor, double outputFactor, double charcoalFactor, double timeFactor,
                            int improvementCount) {
        this.inputFactor = round1(inputFactor);
        this.outputFactor = round1(outputFactor);
        this.charcoalFactor = round1(charcoalFactor);
        this.timeFactor = round1(timeFactor);
        this.improvementCount = improvementCount;
    }

    /**
     * Set factor with explicit min/max (used when applying config caps).
     */
    public void setInputFactorClamped(double min, double max) {
        this.inputFactor = round1(Math.max(min, Math.min(max, inputFactor)));
    }

    public void setOutputFactorClamped(double min, double max) {
        this.outputFactor = round1(Math.max(min, Math.min(max, outputFactor)));
    }

    public void setCharcoalFactorClamped(double min, double max) {
        this.charcoalFactor = round1(Math.max(min, Math.min(max, charcoalFactor)));
    }

    public void setTimeFactorClamped(double min, double max) {
        this.timeFactor = round1(Math.max(min, Math.min(max, timeFactor)));
    }

    private static double round1(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    public double getInputFactor() {
        return inputFactor;
    }

    public double getOutputFactor() {
        return outputFactor;
    }

    public double getCharcoalFactor() {
        return charcoalFactor;
    }

    public double getTimeFactor() {
        return timeFactor;
    }

    public int getImprovementCount() {
        return improvementCount;
    }

    public void setInputFactor(double inputFactor) {
        this.inputFactor = round1(inputFactor);
    }

    public void setOutputFactor(double outputFactor) {
        this.outputFactor = round1(outputFactor);
    }

    public void setCharcoalFactor(double charcoalFactor) {
        this.charcoalFactor = round1(charcoalFactor);
    }

    public void setTimeFactor(double timeFactor) {
        this.timeFactor = round1(timeFactor);
    }

    public void setImprovementCount(int improvementCount) {
        this.improvementCount = improvementCount;
    }

    public RecipeImprovement clone() {
        return new RecipeImprovement(inputFactor, outputFactor, charcoalFactor, timeFactor, improvementCount);
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "RecipeImprovement{input=%.1f,output=%.1f,charcoal=%.1f,time=%.1f,count=%d}",
            inputFactor, outputFactor, charcoalFactor, timeFactor, improvementCount);
    }
}
