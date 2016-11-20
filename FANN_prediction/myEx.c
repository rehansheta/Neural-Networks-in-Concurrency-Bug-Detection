/*
 * modified for the actual dependency data from thread0.
 * rehana 10.02.12
 */

#include <stdio.h>
#include "fixedfann.h"
#include "constants.h"

int main()
{
    fann_type *calc_out;
    fann_type input[10];
    FILE *fp;

    fp = fopen("myOut.txt", "w");  	

    struct fann *ann = fann_create_from_file("dependency.net");

    input[0] = 20665;
    input[1] = 19231;
    input[2] = 17839;
    input[3] = 23227;
    input[4] = 23235;
    input[5] = 20621;
    input[6] = 17920;
    input[7] = 20648;
    input[8] = 19207;
    input[9] = 20677;

    calc_out = fann_run(ann, input);
    fprintf(fp, "ann:(input,output,layers,neuro_hidden,error,max_epochs,epochs_between) -> %d, %d, %d, %d, %f, %d, %d", num_input, num_output, num_layers, num_neurons_hidden, desired_error, max_epochs, epochs_between_reports);
    fprintf(fp, "dependency test (%d,%d,%d,%d,%d,%d,%d,%d,%d,%d) -> %d\n", input[0],input[1],input[2],input[3],input[4],input[5],input[6],input[7],input[8],input[9],calc_out[0]);
    fann_destroy(ann);
    return 0;
}
