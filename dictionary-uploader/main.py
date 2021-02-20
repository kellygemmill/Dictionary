import json
import os
import requests


def load_dictionary():
    dictionary_folder = r'Dictionaries'
    dictionaries_to_add = ['']
    info_file_name = 'index.json'
    for dictionary_to_add in dictionaries_to_add:
        dictionary_path = f'{dictionary_folder}/{dictionary_to_add}'
        with open(f'{dictionary_path}/{info_file_name}', encoding='utf-8') as file:
            info = json.load(file)
            dictionary_data = {
                "name": info["name"],
                "type": info["type"]
            }

        post_dictionary_data(dictionary_path, dictionary_data)


def post_dictionary_data(folder, dictionary_data):
    files = os.listdir(folder)
    files_to_load = [file for file in files if file.__contains__('term_bank')]

    url = 'http://localhost:8080/api'

    dictionary_response = requests.post(f'{url}/dictionary', json=dictionary_data)
    dictionary = eval(dictionary_response.content.decode('utf-8'))

    for file_to_load in files_to_load:
        file_name = folder + f'/{file_to_load}'

        with open(file_name, encoding='utf-8') as file:
            data = json.load(file)
            words_to_add = create_words(data, dictionary)
            requests.post(f'{url}/entry', json=words_to_add)


def create_words(data, dictionary):
    data_out = []
    definition_sep = '; '
    for word in data:
        word_object = {
            "word": word[0],
            "reading": word[1],
            "definition": definition_sep.join(word[5]),
            "dictionary": dictionary
        }
        data_out.append(word_object)

    return data_out


if __name__ == '__main__':
    load_dictionary()
