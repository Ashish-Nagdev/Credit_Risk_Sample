# Implementing Credit_Risk_Sample using Spark ML

Classification
Classification is a family of supervised machine learning algorithms that identify which category an item belongs to based on labeled examples of known items (for example transactions known to be fraud or not). Classification takes a set of data with known labels and pre-determined features and learns how to label new records based on that information. Features are the “if questions” that you ask. The label is the answer to those questions.

Example of Credit Risk for Bank Loans:
What are we trying to predict?
Whether a person will pay back a loan or not.
This is the Label: The Creditability of a person.
What are the “if questions” or properties that you can use to predict ?
An applicant’s demographic and socio-economic profile: Occupation, age, savings, marital status, savings...
These are the Features, to build a classifier model, you extract the features of interest that most contribute to the classification.

Decision Trees
Decision trees create a model that predicts the class or label based on several input features. Decision trees work by evaluating an expression containing a feature at every node and selecting a branch to the next node based on the answer. A possible decision tree for predicting Credit Risk is shown below. The feature questions are the nodes, and the answers “yes” or “no” are the branches in the tree to the child nodes.

Q1: Is checking account balance > 200DM ?
no
Q2: Is Length of current employment > 1 year?
No
Not Creditable
