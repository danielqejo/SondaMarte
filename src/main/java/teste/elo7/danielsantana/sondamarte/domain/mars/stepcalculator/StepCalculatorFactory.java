package teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator;


import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;

public class StepCalculatorFactory {

    public StepCalculator getStepFor(WindRose windRose){
        if(WindRose.E.equals(windRose)){
            return new EastStepCalculator();
        }
        if(WindRose.N.equals(windRose)){
            return new NorthStepCalculator();
        }
        if(WindRose.S.equals(windRose)){
            return new SouthStepCalculator();
        }
        if(WindRose.W.equals(windRose)){
            return new WestStepCalculator();
        }
        throw new IllegalArgumentException("Invalid WindRose: " + windRose);
    }

}
