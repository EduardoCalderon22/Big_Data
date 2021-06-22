### <p align="center" > TECNOLÓGICO NACIONAL DE MÉXICO</p>

### <p align="center" > INSTITUTO TECNOLÓGICO DE TIJUANA</p>

### <p align="center" > SUBDIRECCIÓN ACADÉMICA </p>

### <p align="center" > DEPARTAMENTO DE SISTEMAS Y COMPUTACIÓN </p>

### <p align="center" > PERIODO: Febrero-Julio  2021</p>


###  <p align="center">  Carrera: Ing. En Sistemas Computacionales. 
### <p align="center"> Materia: 	Datos Masivos (BDD-1704 SC9A	).</p>

### <p align="center">  Maestro: Jose Christian Romero Hernandez	</p>
### <p align="center">  No. de control y nombre del alumno: 16210273 - Calderon Acuna Jose Eduardo </p>
### <p align="center">  No. de control y nombre del alumno: 15210743 - Vasquez Macias Cristo Josue</p>


## Index


* [Introducction](#intro)
* [Theoretical Framework](#Th)
    * [Support Vector Machine](#SVM)
    * [Decision Tree Classifier](#Decision-tree)
    * [Logistic Regression](#LR)
    * [Multilayer Perceptron](#MP)
* [Implementation](#Implementation)
* [Results](#Results)
* [Conclusions](#Conclisions)
* [References](#References)

<div id='intro'/>

# Introduction 

Big Data is a broad term for very large or complex data sets that traditional data processing applications are not insufficient to handle. The challenges this new technology presents include analysis, capture, preservation, search, sharing, storage, transfer, display, and privacy information.
In this project we will work with different machine learning algorithms that will help us to better handle the data that we will classify.

<div id='Th'/>

# Theoretical framework

<div id='SVM'/>

## Support Vector Machine

Support Vector Machines constitute a learning-based method for solving classification and regression problems. In both cases, this resolution is based on a first training phase (where they are informed with multiple examples already solved, in the form of pairs {problem, solution}) and a second phase of use for problem solving. In it, SVMs become a "black box" that provides an answer (output) to a given problem (input).

![SVM](https://www.merkleinc.com/es/sites/es/files/inline-images/ml_1.png)


## Decision Tree Classifier

A decision tree or classification tree is a tree in which each internal node (not leaf) is labeled with an input function. The arcs from a node labeled with a feature are labeled with each of the possible values of the feature.

#### Utilization
Decision trees are used in any process that involves decision making, some of these examples are:

* Binary search
* Game trees
* Product planning
* Process analysis
* Plant capacity

#### Advantage
* Some of the advantages of this algorithm are the following:
* Decision trees are easy to interpret and visualize.
* You can easily capture non-linear patterns.
* It requires less data preprocessing by the user, for example, no need to normalize columns.
* It can be used for feature engineering, such as missing value prediction, suitable for variable selection.
* The decision tree has no assumptions about the distribution due to the nonparametric nature of the algorithm.

#### Disadvantages
For its part, the disadvantages of this algorithm are:

* Noise sensitive data, you can oversize noisy data.
* The small variation in the data can lead to a different decision tree.
* They are biased with an unbalanced dataset, so it is recommended to balance the dataset before creating the decision tree.

## Logistic Regression

Logistic regression models the probabilities for classification problems with two possible outcomes. It's an extension of the linear regression model for classification problems.


Logistic regression is the appropriate regression analysis to conduct when the dependent variable is dichotomous (binary).  Like all regression analyses, the logistic regression is a predictive analysis.  Logistic regression is used to describe data and to explain the relationship between one dependent binary variable and one or more nominal, ordinal, interval or ratio-level independent variables.

Sometimes logistic regressions are difficult to interpret; the Intellectus Statistics tool easily allows you to conduct the analysis, then in plain English interprets the output.

Multiple Explanatory Variables
An advantage of logistic regression is that it allows the evaluation of multiple explanatory variables by extension of the basic principles. The general equation is

![1](https://user-images.githubusercontent.com/60414250/123009754-2d9e1780-d372-11eb-8192-ac2f1ea35132.JPG)

Types of Logistic Regression
* 1. Binary Logistic Regression
The categorical response has only two 2 possible outcomes. Example: Spam or Not.
* 2. Multinomial Logistic Regression
Three or more categories without ordering. Example: Predicting which food is preferred more (Veg, Non-Veg, Vegan)
* 3. Ordinal Logistic Regression
Three or more categories with ordering. Example: Movie rating from 1 to 5

## Multilayer Perceptron

 Is a supervised learning algorithm that learns a function by training on a dataset, where  is the number of dimensions for input and  is the number of dimensions for output. Given a set of features and a target , it can learn a non-linear function approximator for either classification or regression. It is different from logistic regression, in that between the input and the output layer, there can be one or more non-linear layers, called hidden layers. Figure 1 shows a one hidden layer MLP with scalar output.

![2](https://user-images.githubusercontent.com/60414250/123009939-8968a080-d372-11eb-866c-376bbb8501aa.JPG)


## Implementation

For the demonstration of the methods of analysis and verification of problems towards the data generated in a result that is verified in bigdata, the task was carried out to find an implementation tool for the use of data manipulation for as well as to generate viable results and effective, for what I entail in this course in using Spark, first of all we will explain that Spark is, as shown in different media and data science forums in Big Data and Machine Learning, it is a fast and efficient engine for storage and processing of the data in large volumes, which shows open source, this is the tool that provides agility in detecting patterns in the data, the organized classification of the information, the execution of intensive computation on the data and parallel processing clusters.

For us it is understandable since its advantages are something good such as:

* Simplify the smart solution development process.
* Improve the performance of data-dependent applications.
* Unify the algorithms so that they work together on various tasks.
* Integrate analytical data modeling within itself.
* Grant scalability in its power by introducing more processors in the system.
* Reduces costs by being able to use standard hardware in common use.

## Results


## Conclusions

## References

https://www.statisticssolutions.com/free-resources/directory-of-statistical-analyses/what-is-logistic-regression/

https://www.sciencedirect.com/topics/medicine-and-dentistry/logistic-regression-analysis

https://www.sciencedirect.com/topics/computer-science/multilayer-perceptron

## 





