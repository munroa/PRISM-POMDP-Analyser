# PRISM-POMDP-Analyser
Tool for generating graphs of POMDP models from PRISM.

 1. Export adversaries from PRISM:

    prism model.prism props.props -exportadv strat.adv

 2. Generate graph

    java main strat.adv -g
