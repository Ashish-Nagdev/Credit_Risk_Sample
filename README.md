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

Random Forests
Random Forest is a popular ensemble learning method for Classification and regression. The algorithm builds a model consisting of multiple decision trees , based on different subsets of data at the training stage. Predictions are made by combining the output from all of the trees which reduces the variance, and improves the predictive accuracy. For Random Forest Classification each tree’s prediction is counted as a vote for one class. The label is predicted to be the class which receives the most votes.

Analyze Credit Risk with Spark Machine Learning Scenario
Our data is bank loan Credit Data Set which classifies people described by a set of attributes as good or bad credit risks.

In this scenario, we will build a random forest of decision trees to predict the label / classification of Creditable or not based on the following features:
Label → Creditable or Not Creditable (1 or 0)
Features → {balance, history, purpose…}

Extract Features
To build a classifier model, you first extract the features that most contribute to the classification. In the german credit data set the data is labeled with two classes – 1 (creditable) and 0 (not creditable).
The features for each item consists of the fields shown below:
Label → creditable: 0 or 1
Features → {"balance", "duration", "history", "purpose", "amount", "savings", "employment", "instPercent", "sexMarried", "guarantors", "residenceDuration", "assets", "age", "concCredit", "apartment", "credits", "occupation", "dependents", "hasPhone", "foreign"}


