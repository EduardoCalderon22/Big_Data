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


- [Introduction](#introduction)
- [Theoretical framework](#theoretical-framework)
  - [Support Vector Machine](#support-vector-machine)
  - [Decision Tree Classifier](#decision-tree-classifier)
      - [Utilization](#utilization)
      - [Advantage](#advantage)
      - [Disadvantages](#disadvantages)
      - [Example](#example)
  - [Logistic Regression](#logistic-regression)
  - [Multilayer Perceptron](#multilayer-perceptron)
  - [Implementation](#implementation)
    - [Code](#code)
  - [Results](#results)
    - [SVM](#svm)
    - [Multilayer Perception](#multilayer-perception)
    - [Decision Tree Classifier](#decision-tree-classifier-1)
    - [Logistic Regression](#logistic-regression-1)
  - [Conclusions](#conclusions)
  - [References](#references)
  
# Introduction 

Big Data is a broad term for very large or complex data sets that traditional data processing applications are not insufficient to handle. The challenges this new technology presents include analysis, capture, preservation, search, sharing, storage, transfer, display, and privacy information.
In this project we will work with different machine learning algorithms that will help us to better handle the data that we will classify.

# Theoretical framework

## Support Vector Machine

Support Vector Machines constitute a learning-based method for solving classification and regression problems. In both cases, this resolution is based on a first training phase (where they are informed with multiple examples already solved, in the form of pairs {problem, solution}) and a second phase of use for problem solving. In it, SVMs become a "black box" that provides an answer (output) to a given problem (input).

![SVM](https://www.merkleinc.com/es/sites/es/files/inline-images/ml_1.png)

In short, they allow you to find the optimal way to classify between various classes. The optimal classification is done by maximizing the separation margin between the classes. The vectors that define the edge of this separation are the support vectors. In the case that the classes are not linearly separable, we can use the kernel trick to add a new dimension where they are.

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

#### Example

![Ejemplo 1](https://miro.medium.com/max/724/1*WerHJ14JQAd3j8ASaVjAhw.jpeg)

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

They are commonly used in operations research, specifically decision analysis, to help identify a strategy most likely to hit a goal, but they are also a popular tool in machine learning.
Logistic regression models the probabilities of classification problems with two possible outcomes. It is an extension of the linear regression model for classification problems.
In statistics, the logistic model (or logit model) is used to model the probability that a certain class or event exists, such as pass / fail, win / lose, alive / dead, or healthy / sick. This can be extended to model various classes of events, such as determining if an image contains a cat, a dog, a lion, and so on. Each object detected in the image will be assigned a probability between 0 and 1, with a sum of one.

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

Spark is a framework that gives us many facilities to work with Big Data. Spark SQL is a Spark module for processing structured data. Unlike the basic Spark RDD API, the interfaces provided by Spark SQL give Spark more information about the structure of both the data and the calculation that is performed. Internally, Spark SQL uses this additional information to perform additional optimizations. There are several ways to interact with Spark SQL, including SQL and the Dataset API. When a result is calculated, the same runtime is used, regardless of which API / language is being used to express the calculation. This unification means that developers can easily switch between different APIs based on which one provides the most natural way to express a given transform.
Now with Scala, Scala is a multi-paradigm programming language that is compatible with the Spark framework. Scala is a programming language with the characteristic of multiple paradigms, in which object-oriented programming and everything related to functional programming are combined, trying not to leave out any detail no matter how small. The name of Scala comes from the meaning Scalable Language, this name has arisen for the purpose of a language capable of growing according to the demand generated by users.

### Code

* [Multilayer Perceptron](https://github.com/EduardoCalderon22/Big_Data/blob/Project/Project/Multilayer.scala)
* [SVM](https://github.com/EduardoCalderon22/Big_Data/blob/Project/Project/SVM.scala)
* [Decision Tree](https://github.com/EduardoCalderon22/Big_Data/blob/Project/Project/decision.scala)
* [Logistic Regression](https://github.com/EduardoCalderon22/Big_Data/blob/Project/Project/logistic.scala)


## Results

### SVM

When testing the code in the scala tool, his time was optimal and fluid at the time of dataset capture and analysis. Its percentage is good not so efficient compared to the others. But it can be a great alternative.

| No.Run | Results | Execution Time |
| ------ | ------- | -------------- |
| 1      | 1.0849  | 9 segs         |
| 2      | 1.0849  | 9 segs         |    
| 3      | 1.0849  | 8 segs         |
| 4      | 1.0849  | 9 segs         |
| 5      | 1.0849  | 9 segs         |
| 6      | 1.0849  | 9 segs         |
| 7      | 1.0849  | 9 segs         |
| 8      | 1.0849  | 10 segs        |
| 9      | 1.0849  | 10 segs        |
| 10     | 1.0849  | 12 segs        |
| 11     | 1.0849  | 11 segs        |
| 12     | 1.0849  | 11 segs        |
| 13     | 1.0849  | 9 segs         |
| 14     | 1.0849  | 9 segs         |
| 15     | 1.0849  | 9 segs         |
| 16     | 1.0849  | 9 segs         |
| 17     | 1.0849  | 8 segs         |
| 18     | 1.0849  | 9 segs         |
| 19     | 1.0849  | 11 segs        | 
| 20     | 1.0849  | 11 segs        |
| 21     | 1.0849  | 8 segs         |
| 22     | 1.0849  | 8 segs         |
| 23     | 1.0849  | 8 segs         |
| 24     | 1.0849  | 10 segs        |
| 25     | 1.0849  | 9 segs         |
| 26     | 1.0849  | 8 segs         |
| 27     | 1.0849  | 8 segs         |
| 28     | 1.0849  | 8 segs         |
| 29     | 1.0849  | 8 segs         |
| 30     | 1.0849  | 9 segs         |

### Multilayer Perception

It is a simple algorithm designed to perform a binary classification; that is, it predicts if the input belongs to a certain category of interest, but when implementing its analysis in the dataset, it can be observed that the execution is something that varies in its execution of each part of the algorithm. Since the data is loaded in a way that the instructions are executing little by little, structuring the corresponding split. It has a late execution time since it is an algorithm that classifies the input by separating two categories with a straight line. A maximum estimated time of 21 seconds was obtained at the time of execution.

| No.Run | Results | Execution Time |
| ------ | ------- | -------------- |
| 1      | 0.8866  | 17segs         |
| 2      | 0.8866  | 16segs         |    
| 3      | 0.8866  | 18segs         |
| 4      | 0.8866  | 18segs         |
| 5      | 0.8866  | 17segs         |
| 6      | 0.8866  | 16segs         |
| 7      | 0.8866  | 19segs         |
| 8      | 0.8866  | 19segs         |
| 9      | 0.8866  | 19segs         |
| 10     | 0.8866  | 18segs         |
| 11     | 0.8866  | 21segs         |
| 12     | 0.8866  | 18segs         |
| 13     | 0.8866  | 17segs         |
| 14     | 0.8866  | 17segs         |
| 15     | 0.8866  | 17segs         |
| 16     | 0.8866  | 17segs         |
| 17     | 0.8866  | 16segs         |
| 18     | 0.8866  | 15segs         |
| 19     | 0.8866  | 16segs         | 
| 20     | 0.8866  | 15segs         |
| 21     | 0.8866  | 15segs         |
| 22     | 0.8866  | 17segs         |
| 23     | 0.8866  | 17segs         |
| 24     | 0.8866  | 18segs         |
| 25     | 0.8866  | 16segs         |
| 26     | 0.8866  | 16segs         |
| 27     | 0.8866  | 15segs         |
| 28     | 0.8866  | 15segs         |
| 29     | 0.8866  | 15segs         |
| 30     | 0.8866  | 16segs         |

### Decision Tree Classifier

When using the decision trees, the results were optimal and the execution time was very similar in almost all the tests we did.

| No.Run | Results | Execution Time |
| ------ | ------- | -------------- |
| 1      | 0.89012 | 9segs         |
| 2      | 0.89229 | 9segs         |    
| 3      | 0.88995 | 9segs         |
| 4      | 0.89505 | 10segs        |
| 5      | 0.89493 | 8segs         |
| 6      | 0.89221 | 9segs         |
| 7      | 0.88775 | 8segs         |
| 8      | 0.90942 | 9segs         |
| 9      | 0.88612 | 10segs        |
| 10     | 0.88839 | 9segs         |
| 11     | 0.89949 | 10segs        |
| 12     | 0.90694 | 10segs        |
| 13     | 0.89673 | 9segs         |
| 14     | 0.88591 | 9segs         |
| 15     | 0.87385 | 9segs         |
| 16     | 0.89232 | 9segs         |
| 17     | 0.89931 | 9segs         |
| 18     | 0.89048 | 10segs        |
| 19     | 0.88629 | 8segs         | 
| 20     | 0.88492 | 10segs        |
| 21     | 0.89385 | 10segs        |
| 22     | 0.88932 | 9segs         |
| 23     | 0.89046 | 9segs         |
| 24     | 0.89855 | 9segs         |
| 25     | 0.90322 | 10segs        |
| 26     | 0.87442 | 10segs        |
| 27     | 0.89541 | 9segs         |
| 28     | 0.88154 | 8segs         |
| 29     | 0.88299 | 9segs         |
| 30     | 0.89375 | 10segs        |

### Logistic Regression

The 30 tests we did with the logistic regression algorithm, the results were very similar. In addition, the execution time was very fast.

| No.Run | Results | Execution Time |
| ------ | ------- | -------------- |
| 1      | 0.88526 | 10segs         |
| 2      | 0.88627 | 9segs          |    
| 3      | 0.88526 | 10segs         |
| 4      | 0.89302 | 9segs          |
| 5      | 0.88824 | 9segs          |
| 6      | 0.88199 | 10segs         |
| 7      | 0.89571 | 10segs         |
| 8      | 0.89185 | 9segs          |
| 9      | 0.89394 | 9segs          |
| 10     | 0.88756 | 9segs          |
| 11     | 0.89384 | 10segs         |
| 12     | 0.89048 | 9segs          |
| 13     | 0.88765 | 9segs          |
| 14     | 0.89219 | 10segs         |
| 15     | 0.88854 | 10segs         |
| 16     | 0.90962 | 10segs         |
| 17     | 0.88759 | 9segs          |
| 18     | 0.88948 | 9segs          |
| 19     | 0.88629 | 8segs          | 
| 20     | 0.89558 | 9segs          |
| 21     | 0.88993 | 10segs         |
| 22     | 0.88901 | 10segs         |
| 23     | 0.88843 | 9segs          |
| 24     | 0.89594 | 9segs          |
| 25     | 0.88755 | 9segs          |
| 26     | 0.88829 | 10segs         |
| 27     | 0.89291 | 9segs          |
| 28     | 0.88154 | 10segs         |
| 29     | 0.88689 | 9segs          |
| 30     | 0.88104 | 9segs          |


## Conclusions
We have taken up several concepts and practices during the course, but an important aspect is to know these models in machine learning to perform the analysis towards a large data set. We observe several results and report as best as possible, each of these algorithms has a different purpose when making decisions. From this in-depth analysis it can be seen that the decision tree algorithm is the most optimal from our point of view because it had a high average efficiency and the fastest to execute. It is also the easiest to understand. Finally, we want to add that Spark is very good at processing large amounts of data and is easy to use even if you are inexperienced in handling this tool.

## References

(John Denker). (Septiembre 1,2020). Machine Learning y Support Vector Machines: porque el tiempo es dinero. June/2021, de MERKLE Sitio web: https://www.merkleinc.com/es/es/blog/machine-learning-support-vector-machines

info@statisticssolutions.com. (2021). What is Logistic Regression?. 23/June/2021, de Complete Dissertation By Statistics Solutions Sitio web: https://www.statisticssolutions.com/free-resources/directory-of-statistical-analyses/what-is-logistic-regression/

Julien I.E. Hoffman. (2015). Logistic Regression Analysis. June/2021, de ScienceDirect Sitio web: https://www.sciencedirect.com/topics/medicine-and-dentistry/logistic-regression-analysis

S. Abirami, P. Chitra. (2020). Multilayer Perceptron. June/2021, de ScienceDirect Sitio web: https://www.sciencedirect.com/topics/computer-science/multilayer-perceptron

Lorraine Li. (2019). Classification and Regression Analysis with Decision Trees. 22/June/2021, de TowardsDataScience Sitio web: https://towardsdatascience.com/https-medium-com-lorrli-classification-and-regression-analysis-with-decision-trees-c43cdbc58054








