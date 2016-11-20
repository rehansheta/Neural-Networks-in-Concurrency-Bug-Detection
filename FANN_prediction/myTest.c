/*
 * modified for the actual dependency data from thread0
 * rehana 10.02.12
 */

#include "fann.h"	// could it be fixedfann.h? --> check
#include "constants.h"

// http://leenissen.dk/fann/html/files/fann-h.html

int main()
{
    struct fann *ann = fann_create_standard(num_layers, num_input,
        num_neurons_hidden, num_output);
   // FANN_API fann_randomize_weights(	ann, 0.1, 0.5);
    fann_set_activation_function_hidden(ann, FANN_SIGMOID_SYMMETRIC);
    fann_set_activation_function_output(ann, FANN_SIGMOID_SYMMETRIC);
    fann_set_training_algorithm(ann,FANN_TRAIN_INCREMENTAL);

/*The first line consists of three numbers: The first is the number of training pairs in the file, the second is the number of inputs and the third is the number of outputs.  The rest of the file is the actual training data, consisting of one line with inputs, one with outputs etc.*/

    fann_train_on_file(ann, "dependency.data", max_epochs,
        epochs_between_reports, desired_error);
    fann_save(ann, "dependency.net");
    fann_print_connections(ann);
//printf("%d". fann_get_training_algorithm(	ann));
    fann_destroy(ann);
    return 0;
}
