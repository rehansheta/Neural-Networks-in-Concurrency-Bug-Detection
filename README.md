# Neural-Networks-in-Concurrency-Bug-Detection

As parallel architectures become mainstream, the issue of writing and debugging parallel programs becomes a ma- jor concern for today’s computing world. Researchers haveshown that diﬀerent types of concurrency bugs can be eﬀec-tively detected by checking the validity of various invariants(e.g. inter-thread communication invariants). Existing in-variant based proposals collect a large number of executiontraces by using various test inputs available from the de-velopers. Then, they analyze those traces and extract therequired invariants. As a result, these proposals suﬀer froma number of limitations arising from this invariant extractionprocess.

In order to remedy this situation, we propose to have continuous learning and veriﬁcation. The high level idea is that as a program starts execution, the neural network initially spends some time learning the invariants. We choose Read-After-Write (RAW) dependences among a write and the following read operations as our pre-ferred invariant. However, we can easily extend this approach to other invariants. After the neural network learnsthe RAW dependences reasonably well, it enters into the veriﬁcation phase where it veriﬁes whether a RAW dependence is correct or not. If a RAW dependence is declared as an incorrect one, then the processor re-executes the relevantread operation and attempts to avoid the concurrency bug. This is likely to avoid most of the concurrency bugs. During the veriﬁcation phase, the neural network keepstrack of its accuracy. If it drops below a certain threshold,the network starts to learn again for a period of time. Thus,the neural network goes through a continuous learning andveriﬁcation phase.

Before implementing the whole system in an architectural simulator, we did some small scale experiments to show the feasibility of neural network usage. We used WEKA, an open source machine learning tool set to implement a multilayer perceptron algorithm. We used last 5 RAW dependences as input, 1 hidden layer with 7 nodes and sigmoid activation function. The learning rate and momentum were 0.3 and 0.2 respectively.

Our preliminary results show that the neural network can quickly train itself to achieve 99% accuracy in categorizing the correctness of any RAW dependences.

# Publication

<https://www.academia.edu/7859828/Concurrency_Bug_Detection_and_Avoidance_Through_Continuous_Learning_of_Invariants_Using_Neural_Networks_in_Hardware>
