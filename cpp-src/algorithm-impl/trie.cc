#include<vector>
#include<string>
#include<iostream>

using namespace std;

typedef struct trie_node {
  bool end;
  int cnt;
  trie_node* next[26];
  trie_node():end(0), cnt(0){for(int i=0;i<26;i++)next[i]=NULL;}
  ~trie_node(){for(int i = 0; i < 26; i++) delete next[i];}
}* trie;

trie buildTrie(){return new trie_node();}

void insert(string s, trie t){
  trie_node* node = t;
  for(auto ch : s) {
    if(!node->next[ch-'a']) node->next[ch-'a'] = new trie_node();
    node = node->next[ch-'a'];
  }
  node->cnt++;
  node->end=1;
}

bool find(string s, trie t) {
  trie_node* node = t;
  for(auto ch : s){
    if(!node->next[ch-'a'])  return false;
    node = node->next[ch-'a'];
  }
  return node->end;
}

int main(){
  trie test_trie = buildTrie();
  insert("apple", test_trie);
  cout << find("apple", test_trie);
return 0;}
