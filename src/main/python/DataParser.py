import json
import xml.etree.ElementTree as ET
import yaml

from src.main.python.Person import Person


class DataParser:
    def parse_xml(self, file_path):
        tree = ET.parse(file_path)
        root = tree.getroot()

        person = Person(name=root.find('Name').text, hobbies=[hobby.text for hobby in root.find('Hobbies')])
        print("Person object from XML:", person)

    def parse_json(self, file_path):
        with open(file_path, 'r') as file:
            person_dict = json.load(file)
            person = Person(**person_dict)
            print("Person object from JSON:", person)

    def parse_yaml(self, file_path):
        with open(file_path, 'r') as file:
            person_dict = yaml.safe_load(file)
            person = Person(**person_dict)
            print("Person object from YAML:", person)


if __name__ == "__main__":
    data_parser = DataParser()
    try:
        data_parser.parse_xml("../resources/me.xml")
        data_parser.parse_json("../resources/me.json")
        data_parser.parse_yaml("../resources/me.yaml")
    except Exception as e:
        print(e)
